import { module, test } from 'qunit';
import { setupTest } from 'sample/tests/helpers';

module('Unit | Route | load', function (hooks) {
  setupTest(hooks);

  test('it exists', function (assert) {
    let route = this.owner.lookup('route:load');
    assert.ok(route);
  });
});
