module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: 'src/<%= pkg.name %>.js',
        dest: 'build/<%= pkg.name %>.min.js'
      }
    },
    bower: {
        install: {
          options: {
            targetDir: './src/main/webapp/resources',
            install: true,
            verbose: true,
            cleanTargetDir: false,
            cleanBowerDir: false,
            bowerOptions: {}
        }
      }
    },
    less: {
      development: {
        options: {
          paths: ['./src/main/webapp/resources/css']
        },
        files: {
          "./src/main/webapp/resources/bootstrap/bootstrap.css": "./src/main/webapp/resources/bootstrap/bootstrap.less"
        }
      }
    }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-bower-task');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-qunit');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-bower-task');
  grunt.loadNpmTasks('grunt-contrib-less');

  // Default task(s).
  grunt.registerTask('default', ['uglify', 'jshint']);

};