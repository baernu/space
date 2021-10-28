/**
 * Project and Training 2: Space News - Computer Science, Berner Fachhochschule
 *
 * Specification of requiered Java modules. Add further entries if necessary.
 */
module spacenewsfx {
	// JavaFX
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;

	// FasterXML JSON library
	requires com.fasterxml.jackson.core;

	exports ch.bfh.spacenews;
 }
