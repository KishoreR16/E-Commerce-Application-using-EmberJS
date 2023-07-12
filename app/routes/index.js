import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { action } from '@ember/object';
export default class IndexRoute extends Route {
  @service store;
  async model() {
    return this.store.findAll('info');
  }
  @action
  loading(transition, originRoute) {
    console.log("at loading index");
    let controller = this.controllerFor('load');
    controller.set('currentlyLoading', true);
    return true; // allows the loading template to be shown
  }

  @action
  error(error, transition) {
    console.log("error");
    transitionTo("load");
  }
}
