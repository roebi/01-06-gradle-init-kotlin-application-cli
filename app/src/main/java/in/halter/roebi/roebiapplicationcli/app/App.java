/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package in.halter.roebi.roebiapplicationcli.app;

import in.halter.roebi.roebiapplicationcli.list.LinkedList;

import static in.halter.roebi.roebiapplicationcli.utilities.StringUtils.join;
import static in.halter.roebi.roebiapplicationcli.utilities.StringUtils.split;
import static in.halter.roebi.roebiapplicationcli.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}
