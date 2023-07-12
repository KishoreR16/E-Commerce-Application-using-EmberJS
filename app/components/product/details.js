import Component from '@glimmer/component';
import { inject as service } from '@ember/service';
import { action } from '@ember/object';
export default class ProductDetailsComponent extends Component {
  @service('shopping-cart') cart;

  @action
  addToCart() {
    const { name, color, colors, price } = this.args;
    console.log('hello');
    console.log('name is ' + name);
    console.log('color is ' + color);
    console.log('price is' + price.current);
    // const product = data.find(({ id }) => id === item_id);
    const product = colors.find((colorInf) => colorInf.color);
    console.log('hello is ' + product);
    this.cart.addItem({
      name,
      color,
      image: colors.find((colorInfo) => colorInfo.color === color).image,
      price: price.current,
    });
  }
}
