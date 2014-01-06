var express = require('express');
var path = require('path');
var _ = require('underscore');
//var controllers = require('./lib/controllers');

var app = express();

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger());
app.use(express.bodyParser());
app.use(express.methodOverride());
// 随机延时
app.use(function(req, res, next) {
    if (/^\/assets\//.test(req.url) || req.url === '/') {
        next();
    }
    else {
        setTimeout(next, _.random(300, 1000));
    }
});
app.use('/assets', express.static(path.join(__dirname, '../assets')));
app.use(app.router);

// home
app.get('/', function(req, res) {
    res.render('index');
});

require('./controller/shelf')(app);

//
//app.get('/shelf/plan-settings', function(req, res) {
//    var json = requireUncached('./json/shelf/plan-settings.json');
//    json.pageNum = parseInt(req.query.page || 1);
//    res.json(json);
//});
//app.get('/shelf/plan-settings/chart', function(req, res){
//    var json = requireUncached('./json/shelf/chart.json');
//    res.json(json);
//});
//app.get('/shelf/sellercats', function(req, res) {
//    var json = requireUncached('./json/shelf/sellercats.json');
//    res.json(json);
//});
//app.get('/shelf/plan-settings/:id/items', function(req, res) {
//    var json = requireUncached('./json/shelf/items.json');
//    json.pageNum = parseInt(req.query.page || 1);
//    res.json(json);
//});
//app.get('/shelf/plan-settings/:id', function(req, res){
//    var json = requireUncached('./json/shelf/plan-setting.json');
//    res.json(json);
//});
//app.post('/shelf/plan-settings/:id/items/:nid/exclude', function(req, res){
//    req.body.exclude = true;
//    res.json(req.body);
//});
//
//app.del('/shelf/plan-settings/:id/items/:nid/exclude', function(req, res){
//    req.body.exclude = false;
//    res.json(req.body);
//});

app.listen(8888);
