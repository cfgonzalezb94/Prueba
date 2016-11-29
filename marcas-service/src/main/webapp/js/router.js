// Filename: router.js
define([
  'jquery',
  'underscore',
  'backbone',
  'views/home/HomeView',
  'views/projects/ProjectsView',
  'views/contributors/ContributorsView',
  'views/footer/FooterView',
  'views/usuario/eliminarUsuarioView',
  'views/otros/funcionamientoView',
  'views/otros/generarSoporteView',
  'views/usuario/modificarUsuarioView',
    
], function($, _, Backbone, HomeView, ProjectsView, ContributorsView, FooterView, eliminarUsuarioView, funcionamientoView, generarSoporteView, modificarUsuarioView) {
  
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      'projects': 'showProjects',
      'users': 'showContributors',
      'usuario': 'showeliminarUsuario',
      'usuario': 'showmodificarUsuario',
      'otros': 'showfuncionamiento',
      'otros': 'showgenerarSoporte',
     
      // Default
      '*actions': 'defaultAction'
    }
  });
  
  var initialize = function(){

    var app_router = new AppRouter;
    
    app_router.on('route:showProjects', function(){
   
        // Call render on the module we loaded in via the dependency array
        var projectsView = new ProjectsView();
        projectsView.render();

    });

    app_router.on('route:showContributors', function () {
    
        // Like above, call render but know that this view has nested sub views which 
        // handle loading and displaying data from the GitHub API  
        var contributorsView = new ContributorsView();
    });

    app_router.on('route:defaultAction', function (actions) {
     
       // We have no matching route, lets display the home page 
        var homeView = new HomeView();
        homeView.render();
    });
    
    app_router.on('route:showeliminarUsuario', function () {
        
    	var eliminarView = new eliminarUsuarioView();
    	eliminarView.render();
     });

    app_router.on('route:showmodificarUsuario', function () {
        
    	var modificarView = new modificarUsuarioView();
    	modificarView.render();
     });

    app_router.on('route:showfuncionamiento', function () {
        
    	var funciView = new funcionamientoView();
    	funciView.render();
     });

    app_router.on('route:showgenerarSoporte', function () {
        
    	var generaView = new generarSoporteView();
    	generaView.render();
     });
    // Unlike the above, we don't call render on this view as it will handle
    // the render call internally after it loads data. Further more we load it
    // outside of an on-route function to have it loaded no matter which page is
    // loaded initially.
    var footerView = new FooterView();
    var eliminarUsuarioView = new eliminarUsuarioView();
    var funcionamientoView = new funcionamientoView();
    var generarSopoteView = new generarSoporteView();
    var modificarUsuarioView = new modificarUsuarioView();
    
    Backbone.history.start();
  };
  return { 
    initialize: initialize
  };
});
