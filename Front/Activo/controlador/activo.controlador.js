(function () {
  'use strict';

  angular
    .module('fiduinversion')
    .controller('ActivoControlador',ActivoControlador);

  /** @ngInject */
  function ActivoControlador($scope, $log, $http,
                             lodash,
                             $translate, $state, $rootScope,ActivoServicio,
                             TipoActivoServicio ) {
    var vm = this;
    vm.initActivo = function () {
      vm.consultaFiltro();
      vm.consultaTipo();
    };

    vm.consultaFiltro = function () {

      var data = {
        fecha: lodash.get(vm, 'fechaCompra', ''),
        serial: lodash.get(vm, 'serial', ''),
        tipo: lodash.get(vm, 'tipo.id_tipo', '')

      };

      $log.debug("imprime data ",data);
      ActivoServicio.get(data,
        function (resultado) {
          vm.listaActivo = resultado.lista;
          $log.debug("imprime lista ",vm.listaActivo);
          $log.debug("imprime ",vm.listaActivo[0].serial);
        },function(error){
          $log.error("Error en activo -> ", error);
        });
    };

    vm.consultaTipo = function () {
      TipoActivoServicio.get({},
        function (resultado) {
          vm.listaTipo = resultado.lista;
          $log.debug("imprime ",vm.listaTipo);
        },function(error){
          $log.error("Error en activo -> ", error);
        });
    };


  }})();
