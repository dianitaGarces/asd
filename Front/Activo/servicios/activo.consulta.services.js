(function () {
  angular.module('fiduinversion')
    .service('ActivoServicio', ActivoServicio);
  function ActivoServicio($resource) {
    return $resource(
      'api/consultarActivo',
      {},
      {
        save: {
          method: 'POST'
        }
      }

    );
  }
})();
