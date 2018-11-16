package com.demo.showrdd

@SerialVersionUID(268278L)
class Tempdata extends Serializable {
  var id: Int = 0;
  var name: String = null;
  var age: Int = 0;

  def this(_id: Int, _name: String, _age: Int) {
    this();
    this.id = _id;
    this.name = _name;
    this.age = _age;
  }

  override def toString(): String = "(" + id + " " + name + " " + age + ")"

}