var express = require('express'),
  path = require('path'),
  logger = require('morgan'),
  cookieParser = require('cookie-parser'),
  bodyParser = require('body-parser'),
  fileUtils = require('./app/utils/file.utils'),
  nunjucks  = require('nunjucks'),
  session = require('express-session');

var app = express();


// view engine setup
app.set('views', path.join(__dirname, '/app/views'));
app.set('view engine', 'view.html');

var nunjucksEnv = new nunjucks.Environment(new nunjucks.FileSystemLoader(app.get('views'), {watch: true }),
  {autoescape: false}
);

nunjucksEnv.express(app);



app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());

// Serve static resources
app.use('/static/', express.static(path.resolve('./public')));

app.use(session({
  name: 'SESSIONID',
  secret: 'mysecret',
  resave: false,
  saveUninitialized: true,
  cookie: { httpOnly: false }
}));

app.use(function(req, res, next) {
  res.locals.session = req.session;
  next();
});


// Globbing routing files
fileUtils.getGlobbedFiles('./app/routes/*.js').forEach(function (routePath) {
  require(path.resolve(routePath))(app);
});

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers
// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: JSON.stringify(err)
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});


module.exports = app;
