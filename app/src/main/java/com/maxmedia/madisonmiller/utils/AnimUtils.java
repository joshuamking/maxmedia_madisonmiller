package com.maxmedia.madisonmiller.utils;

import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by joshua on 2/3/16.
 */
@SuppressWarnings ("WeakerAccess")
public class AnimUtils {
	public static final int DEFAULT_DELAY    = 0;
	public static final int DEFAULT_DURATION = 250;

	public static ViewPropertyAnimator anim (View v) {
		return anim(v, DEFAULT_DURATION);
	}

	public static ViewPropertyAnimator anim (View v, int duration) {
		return anim(v, duration, DEFAULT_DELAY);
	}

	public static ViewPropertyAnimator anim (View v, int duration, int delay) {
		return v.animate().setDuration(duration).setStartDelay(delay);
	}

	public static ViewPropertyAnimator fade (View v, int alpha) {
		return fade(v, DEFAULT_DURATION, alpha);
	}

	public static ViewPropertyAnimator fade (View v, int duration, int alpha) {
		return fade(v, duration, DEFAULT_DELAY, alpha);
	}

	public static ViewPropertyAnimator fade (View v, int duration, int delay, int alpha) {
		return anim(v, duration, delay).alpha(alpha);
	}

	public static ViewPropertyAnimator fadeIn (View v) {
		return fadeIn(v, DEFAULT_DURATION);
	}

	public static ViewPropertyAnimator fadeIn (View v, int duration) {
		return fadeIn(v, duration, DEFAULT_DELAY);
	}

	public static ViewPropertyAnimator fadeIn (View v, int duration, int delay) {
		return fade(v, duration, delay, 1);
	}

	public static ViewPropertyAnimator fadeOut (View v) {
		return fadeOut(v, DEFAULT_DURATION);
	}

	public static ViewPropertyAnimator fadeOut (View v, int duration) {
		return fadeOut(v, duration, DEFAULT_DELAY);
	}

	public static ViewPropertyAnimator fadeOut (View v, int duration, int delay) {
		return fade(v, duration, delay, DEFAULT_DELAY);
	}

	public static ViewPropertyAnimator scaleBy (View v, float scale) {
		return scaleBy(v, DEFAULT_DURATION, scale);
	}

	public static ViewPropertyAnimator scaleBy (View v, int duration, float scale) {
		return scaleBy(v, duration, DEFAULT_DELAY, scale);
	}

	public static ViewPropertyAnimator scaleBy (View v, int duration, int delay, float scale) {
		return anim(v, duration, delay).scaleXBy(scale).scaleYBy(scale);
	}

	public static ViewPropertyAnimator scaleTo (View v, float scale) {
		return scaleTo(v, DEFAULT_DURATION, scale);
	}

	public static ViewPropertyAnimator scaleTo (View v, int duration, float scale) {
		return scaleTo(v, duration, DEFAULT_DELAY, scale);
	}

	public static ViewPropertyAnimator scaleTo (View v, int duration, int delay, float scale) {
		return anim(v, duration, delay).scaleX(scale).scaleY(scale);
	}
}
