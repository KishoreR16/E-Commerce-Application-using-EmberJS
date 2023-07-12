import EmberRouter from '@ember/routing/router';
import config from 'sample/config/environment';

export default class Router extends EmberRouter {
  location = config.locationType;
  rootURL = config.rootURL;
}

Router.map(function () {
  this.route('not-found', { path: '/*path' });
  this.route('item', { path: '/item/:item_id' });
  this.route('cart', { path: 'shopping-cart' });
  this.route('load');
});
