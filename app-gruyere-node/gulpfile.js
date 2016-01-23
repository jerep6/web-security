var gulp = require('gulp')
    nodemon = require('nodemon'),
    sass = require('gulp-sass');

const PATHS = {
  clientSass: ['./app/sass/*.scss'],
  watchSass: ['./app/sass/**/*.scss']
};


gulp.task('watch', function () {
  gulp.watch(PATHS.watchSass, ["sass"]);
});


gulp.task('sass', function () {
  console.log('----------');
  gulp.src(PATHS.clientSass)
    .pipe(sass().on('error', sass.logError))
    .pipe(gulp.dest('./public/styles/'));
});

// Rerun the task when a file changes
gulp.task('server', function() {
  nodemon({
    script: "bin/www",
    nodeArgs: ["--debug"],
    ext: "js,html",
    ignore: ["node_modules/**"],
    tasks: ["sass"]
  });
});

// The default task (called when you run `gulp` from cli)
gulp.task('default', ['sass', 'server', 'watch']);