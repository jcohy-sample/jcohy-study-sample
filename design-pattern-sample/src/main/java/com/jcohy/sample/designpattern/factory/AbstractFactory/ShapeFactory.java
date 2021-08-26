package com.jcohy.sample.designpattern.factory.AbstractFactory;

/**
 * @author jcohy
 *
 */
// tag::code[]
public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return (Shape) new Circle();
		}
		else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return (Shape) new Rectangle();
		}
		else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return (Shape) new Square();
		}
		return null;
	}

	@Override
	Color getColor(String color) {
		return null;
	}

}
// end::code[]