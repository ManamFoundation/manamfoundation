'use strict';

module.exports = function (grunt) {
    var appPath = './app/';
    var tempPath = './tmp/';
    var resourcePath = '../src/main/resources/';

    var javaAppArtifactLocation = '../build/libs/';
    var javaAppPort = 8080;

    var globalConfig = {
    		generatedAssetDestination: '../src/main/resources/static/',
    		buildDestination: '../build/resources/main/public/gen/',
    		resourceDestination: resourcePath,

    		appPath: appPath,
    		tempPath: tempPath,
    		jsPath: appPath + 'js/',
    		partialsPath: appPath + 'partials/',
    		lessPath: appPath + 'less/',
    	};

  grunt.initConfig({
  		globalConfig: globalConfig,

  		availabletasks: {
  			tasks: {}
  		},

  		uglify: {
  			manam: {
  				options: {
  					compress: {
  						drop_debugger: false
  					},
  					mangle: false,
  					preserveComments: 'all',
  					beautify: true,
  					ASCIIOnly: true,
  					sourceMap: true,
  					sourceMapName: '<%= globalConfig.generatedAssetDestination %>manam.js.map',
  					sourceMapIncludeSources: true
  				},
  				files: {
  					'<%= globalConfig.generatedAssetDestination %>manam.js': [
  						'<%= globalConfig.jsPath %>ManamCommon.js',
  						'<%= globalConfig.jsPath %>ManamApp.js',
  						'<%= globalConfig.jsPath %>manam/**/*.js',
  						'<%= globalConfig.jsPath %>services/**/*.js',
  						'<%= globalConfig.jsPath %>repositories/**/*.js',
  						'<%= globalConfig.jsPath %>directives/**/*.js',
  						'<%= globalConfig.jsPath %>filters/**/*.js',
  						'<%= globalConfig.tempPath %>partials.js'
  					]
  				}
  			},
  			thirdParty: {
  				options: {
  					mangle: false,
  					preserveComments: 'all',
  					beautify: true,
  					ASCIIOnly: true,
  					sourceMap: true,
  					sourceMapName: '<%= globalConfig.generatedAssetDestination %>thirdParty.js.map',
  					sourceMapIncludeSources: true
  				},
                 				files: {
                 					'<%= globalConfig.generatedAssetDestination %>thirdParty.js': [require('./third-party-app-dependencies')]
                 				}
  			}
  		},

  		html2js: {
  			options: {
  				module: 'partials',
  				base: '<%= globalConfig.partialsPath %>'
  			},
  			main: {
  				src: ['<%= globalConfig.partialsPath %>**/*.html'],
  				dest: '<%= globalConfig.tempPath %>partials.js'
  			}
  		},

  		less: {
  			manam: {
  				options: {
  					paths: ['<%= globalConfig.lessPath %>'],
  					sourceMap: true,
  					sourceMapFileInline: true
  				},
  				files: {
  					'<%= globalConfig.generatedAssetDestination %>manam.css': '<%= globalConfig.lessPath %>manam.less'
  				}
  			}
  		},

  		copy: {
  			generatedFilesToBuild: {
  				expand: true,
  				src: ['**/*'],
  				cwd: '<%= globalConfig.generatedAssetDestination %>',
  				dest: '<%= globalConfig.buildDestination %>'
  			}
  		}

  	});

    require('load-grunt-tasks')(grunt);
    grunt.loadNpmTasks('grunt-available-tasks');
    grunt.loadNpmTasks('grunt-html2js');

    grunt.registerTask('clean', function () {
        grunt.file.delete(globalConfig.buildDestination, {force: true});
    });

    grunt.registerTask('default', ['clean', 'html2js', 'uglify', 'copy:generatedFilesToBuild']);

    grunt.registerTask('task', ['availabletasks']);
}