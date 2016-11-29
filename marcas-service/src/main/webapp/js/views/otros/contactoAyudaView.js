define([
  'jquery',
  'underscore',
  'backbone',
  'views/sidebar/SidebarView',
  'text!templates/marca/contactoAyuda.html'
], function($, _, Backbone, SidebarView, contactoAyuda){

  var contactoAyuda2 = Backbone.View.extend({
    el: $("#page"),

    render: function(){
      
      $('.menu li').removeClass('active');
      $('.menu li a[href="#/contactoA"]').parent().addClass('active');
      this.$el.html(contactoAyuda);

      var sidebarView = new SidebarView();
      sidebarView.render();
 
    }

  });

  return contactoAyuda2;
  
});
