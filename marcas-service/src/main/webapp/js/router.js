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
  'views/usuario/LoginView', 
  'views/usuario/crearUsuarioView',
  'views/otros/contactoAyudaView',
  'views/otros/PaginaInicioView'
    
], function($, _, Backbone, HomeView, ProjectsView, ContributorsView, FooterView, eliminarUsuarioView, funcionamientoView, generarSoporteView, modificarUsuarioView, LoginView, crearUsuarioView,
		contactoAyudaView,paginaInicioView) {
  
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      'projects': 'showProjects',
      'users': 'showContributors',
      'eliminarU': 'showeliminarUsuario',
      'modificarU': 'showmodificarUsuario',
      'funcionamientoU': 'showfuncionamiento',
      'generarU': 'showgenerarSoporte',
      'login' : 'showLogin',
	  'crearU' : 'showCrearUsuario',
	  'contactoA' : 'showContactoAyuda',
	  'pInicio':'showPaginaInicio',
     
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
        
    	var genera_SopView = new generarSoporteView();
    	genera_SopView.render();
     });
    
    app_router.on('route:showLogin', function() {
		var loginView = new LoginView();
		loginView.render();

	});

	app_router.on('route:showCrearUsuario', function() {
		var crear = new crearUsuarioView();
		crear.render();
	});

	app_router.on('route:showContactoAyuda', function() {
		var contac = new contactoAyudaView();
		contac.render();

	});
	
	app_router.on('route:showPaginaInicio', function() {
		var pInicio = new paginaInicioView();
		pInicio.render();

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
