import { module, test } from 'qunit';
import { setupTest } from 'sample/tests/helpers';

module('Unit | Controller | load', function (hooks) {
  setupTest(hooks);

  // TODO: Replace this with your real tests.
  test('it exists', function (assert) {
    let controller = this.owner.lookup('controller:load');
    assert.ok(controller);
  });
});
