package com.eaton.hug4bugs.testgoodpractice.badcodebase;

/**
 * This is a marking annotation to be applied on a class or method to mark it as only exposed for testing purpose.
 * This is only for documentation purpose and don't protected.
 * This annotation is available in Guava. But since it only a marking interface you may create your own.
 */
public @interface VisibleForTesting {
}
