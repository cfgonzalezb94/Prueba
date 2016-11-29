define([
  'jquery',
  'underscore',
  'backbone',
  'views/sidebar/SidebarView',
  'text!templates/usuario/modificarUsuario.html'
], function($, _, Backbone, SidebarView, modificarUsuario){

  var modificarUsuarioView = Backbone.View.extend({
    el: $("#page"),

    render: function(){
      
      $('.menu li').removeClass('active');
      $('.menu li a[href="#/modificar_Usuario"]').parent().addClass('active');
      this.$el.html(modificarUsuario);

      var sidebarView = new SidebarView();
      sidebarView.render();
 
    }

  });

  return modificarUsuarioView;
  
});