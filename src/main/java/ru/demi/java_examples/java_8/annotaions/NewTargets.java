package ru.demi.java_examples.java_8.annotaions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by demi
 * on 06.09.15.
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface NewTargets {
}
