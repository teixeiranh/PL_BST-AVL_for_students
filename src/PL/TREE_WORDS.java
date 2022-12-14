
package PL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author DEI-ESINF
 */
public class TREE_WORDS extends BST<TextWord> {

    public void createTree() throws FileNotFoundException {
        Scanner readfile = new Scanner(new File("src/PL/xxx.xxx"));
        while (readfile.hasNextLine()) {
            String[] pal = readfile.nextLine().split("(\\,)|(\\s)|(\\.)");
            for (String word : pal)
                if (word.length() > 0)
                    insert(new TextWord(word, 1));
        }
        readfile.close();
    }

    /**
     * Inserts a new word in the tree, or increments the number of its occurrences.
     *
     * @param element
     */
    @Override
    public void insert(TextWord element) {
        if (element == null) {
            return;
        }
        if (this.isEmpty()) {
            root = new Node<>(element, null, null);
        }
        insert(element, root);
    }

    // recursive method
    private Node<TextWord> insert(TextWord element, Node<TextWord> node) {
        if (node == null) {
            return new Node<>(element, null, null);
        }
        if (node.getElement().compareTo(element) > 0) {
            node.setLeft(insert(element, node.getLeft()));
        }
        if (node.getElement().compareTo(element) == 0) {
            node.getElement().incOcorrences();
        }

        if (node.getElement().compareTo(element) < 0) {
            node.setRight(insert(element, node.getRight()));
        } else if (node.getElement().equals(element)) {
            element.incOcorrences();
        }

        return node;
    }

    /**
     * Returns a map with a list of words for each occurrence found.
     *
     * @return a map with a list of words for each occurrence found.
     */
    public Map<Integer, List<String>> getWordsOccurrences() {
        Iterable<TextWord> textWordList = this.inOrder();
        Map<Integer, List<String>> output = new TreeMap<>();

        textWordList.forEach(textWord -> {
            if (!output.containsKey(textWord.getOcorrences()))
                output.put(textWord.getOcorrences(), new ArrayList<>());

            List<String> thisWordList = output.get(textWord.getOcorrences());
            thisWordList.add(textWord.getWord());

        });
        return output;
    }

}
