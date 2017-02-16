(function () {
  'use strict';

  angular
    .module('fiduinversion')
    .controller('ActivoCreaControlador',ActivoCreaControlador);

  /** @ngInject */
  function ActivoCreaControlador($scope, $log, $http,
                             lodash,
                             $translate, $state, $rootScope,ActivoServicio,
                             TipoActivoServicio ) {
    var vm = this;
    vm.initCreaActivo = function () {
           TipoActivoServicio.get({},
        function (resultado) {
          vm.listaTipo = resultado.lista;
          $log.debug("imprime ",vm.listaTipo);
        },function(error){
          $log.error("Error en activo -> ", error);
        });

      vm.activo = new TipoActivoServicio();
    };

    vm.crearActivo = function (formCrear){
      if(formCrear.$valid) {

        vm.activo.id_tipo= vm.tipo.id_tipo;
        $log.debug("Creando ",vm.activo);
        vm.activo.$save(function (resultado) {
          $log.debug("inserto ",resultado);

        }, function (err) {
          $log.error("error al crear ",err);
        });
      }
    };


  }})();
