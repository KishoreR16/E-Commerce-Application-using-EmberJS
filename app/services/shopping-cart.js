import Service from '@ember/service';
import { tracked } from '@glimmer/tracking';
//import {action} from '@ember/object';

class Item {
  @tracked count;

  name;
  color;
  image;
  price;

  constructor(item) {
    this.count = item.count;
    this.name = item.name;
    this.color = item.color;
    this.image = item.image;
    this.price = item.price;
  }
}

export default class ShoppingCartService extends Service {
  @tracked itemList = [];

  addItem(item) {
    const existingItem = this.itemList.find(({ name, color }) => {
      console.log('name is ' + name);
      console.log('item name is ' + item.name);
      console.log('color is ' + color);
      console.log('item color is ' + item.color);
      console.log('end');
      return name === item.name && color === item.color;
    });

    if (existingItem) {
      existingItem.count += 1;
    } else {
      this.itemList = [
        ...this.itemList,
        new Item({
          ...item,
          count: 1,
        }),
      ];
    }
  }
}
