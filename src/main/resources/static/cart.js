angular.module('cart', []).controller('cartController', function ($scope, $http) {
    $scope.fillCart = function () {
        $http.get('http://localhost:8189/market/api/v1/cart')
            .then(function (response) {
                $scope.cart = response.data;
            });
    };

    $scope.clearCart = function () {
        $http.get('http://localhost:8189/market/api/v1/cart/clear')
            .then(function (response) {
                $scope.fillCart();
            });
    }

    $scope.fillCart();
});