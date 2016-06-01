package org.grails.gdoc.asciidoc.engine.filters

import org.radeox.filter.regex.RegexTokenFilter
import org.radeox.regex.MatchResult
import org.radeox.filter.context.FilterContext

class ImageFilter extends RegexTokenFilter {
    ImageFilter() {
        super(/!([^\n<>=]*?\.(jpg|png|gif))!/);
    }

    void handleMatch(StringBuffer buffer, MatchResult result, FilterContext context) {
        def img = result.group(1)
        // This assumes the image directories have been correctly setup
        buffer << "image::$img[]"
    }
}