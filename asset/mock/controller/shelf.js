function requireUncached(module) {
    delete require.cache[require.resolve(module)];
    return require(module);
}

module.exports = function(app) {

    app.get('/shelf/plan-settings', function(req, res) {
        var json = requireUncached('../json/shelf/plan-settings.json');
        json.pageNum = parseInt(req.query.page || 1);
        res.json(json);
    });

    app.get('/shelf/plan-settings/chart', function(req, res) {
        var json = requireUncached('../json/shelf/chart.json');
        res.json(json);
    });

    app.post('/shelf/plan-settings/:id/pause', function(req, res){
        req.body.paused = true;
        res.json(req.body);
    });
    app.del('/shelf/plan-settings/:id/pause', function(req, res){
        req.body.paused = false;
        res.json(req.body);
    });

    app.get('/shelf/sellercats', function(req, res) {
        var json = requireUncached('../json/shelf/sellercats.json');
        res.json(json);
    });
    app.get('/shelf/plan-settings/:id/items', function(req, res) {
        var json = requireUncached('../json/shelf/items.json');
        json.pageNum = parseInt(req.query.page || 1);
        res.json(json);
    });
    app.get('/shelf/plan-settings/:id', function(req, res) {
        var json = requireUncached('../json/shelf/plan-setting.json');
        res.json(json);
    });
    app.post('/shelf/plan-settings/:id/items/:nid/exclude', function(req, res) {
        req.body.exclude = true;
        res.json(req.body);
    });

    app.del('/shelf/plan-settings/:id/items/:nid/exclude', function(req, res) {
        req.body.exclude = false;
        res.json(req.body);
    });
};