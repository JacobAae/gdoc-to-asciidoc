package org.grails.gdoc.asciidoc

import org.grails.gdoc.asciidoc.engine.AsciiDocTemplateEngine
import spock.lang.Specification

class ImageFilterSpec extends Specification {

    void "Test that !filename.png! is handled as an image"() {
        given:"A template engine"
        def engine = new AsciiDocTemplateEngine()

        when:"A template is rendered with code !filename.png! formatting"
        def sw = new StringWriter()
        engine.createTemplate("!filename.${ending}!").make().writeTo(sw)

        then:"The output is correct"
        sw.toString() == "image::filename.${ending}[]"

        where:
        ending << ['png', 'jpg', 'gif']
    }
}
