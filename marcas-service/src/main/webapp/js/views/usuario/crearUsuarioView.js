define([
  'jquery',
  'underscore',
  'backbone',
  'views/sidebar/SidebarView',
  'text!templates/usuario/crearUsuario.html'
], function($, _, Backbone, SidebarView, crearUsuario){

  var crearUsuario2 = Backbone.View.extend({
    el: $("#page"),

    render: function(){
      
      $('.menu li').removeClass('active');
      $('.menu li a[href="#/crearU"]').parent().addClass('active');
      this.$el.html(crearUsuario);

      var sidebarView = new SidebarView();
      sidebarView.render();
 
    }

  });

  return crearUsuario2;
  
});
