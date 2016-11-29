define([
  'jquery',
  'underscore',
  'backbone',
  'views/sidebar/SidebarView',
  'text!templates/usuario/login.html'
], function($, _, Backbone, SidebarView, login){

  var login2 = Backbone.View.extend({
    el: $("#page"),

    render: function(){
      
      $('.menu li').removeClass('active');
      $('.menu li a[href="#/login"]').parent().addClass('active');
      this.$el.html(login);

      var sidebarView = new SidebarView();
      sidebarView.render();
 
    },

    events: {
      "click #loginButton": "login"
    }, 

    login: function(){
      var usuarios= document.getElementById("USER").value;
      var contrasena=document.getElementById("PASS").value;
      alert(usuarios+""+contrasena);
    }

  });

  return login2;
  
});
