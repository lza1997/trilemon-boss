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
// is mac?
app.use(function(req, res, next) {
    req.isMac = /mac/.test(req.header('User-Agent').toLowerCase());
    res.locals.req = req;
    next();
});
app.use('/assets', express.static(path.join(__dirname, '../assets')));
app.use(app.router);

// home
app.get('/', function(req, res) {
    res.render('index');
});

require('./controller/shelf')(app);

app.listen(8888);
require("openurl").open("http://localhost:8888");