/**
 * Created by itc on 14/12/2016.
 */
(function () {
  'use strict';

  angular
    .module('fiduinversion')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
    $stateProvider

      .state('activo', {
        abstract: true,
        url: '/activo',
        templateUrl: '/app/public/temporal/vista/activo.html',
        controller: 'ActivoControlador',
        controllerAs: 'activoCtrl'
      })

      .state('activo.consulta', {
        url: '/consulta',
        templateUrl: '/app/public/temporal/vista/activo.html',
        controller: 'ActivoControlador',
        controllerAs: 'activoCtrl'
      })

      .state('activo.crear', {
        url: '/crear',
        templateUrl: '/app/public/temporal/vista/activo.crear.html',
        controller: 'ActivoCreaControlador',
        controllerAs: 'ctrlCrearActivo'
      });
  }

})();
