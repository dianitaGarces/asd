(function () {
  angular.module('fiduinversion')
    .service('TipoActivoServicio', TipoActivoServicio);
  function TipoActivoServicio($resource) {
    return $resource(
      'api/consultarTipoActivo',
      {},
      {
        save: {
          method: 'POST'
        }
      }

    );
  }
})();
