package seedu.address.logic.autocomplete.nodes.phone;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import seedu.address.logic.autocomplete.nodes.AutoCompleteNode;
import seedu.address.model.phone.Phone;

/**
 * Represents a {@code Node} tracking {@code Phone} {@code Cost} for autocompletion.
 */
public class PhoneCostNode extends AutoCompleteNode<List<Phone>> {

    public PhoneCostNode(List<Phone> pointer) {
        super(pointer);
    }

    @Override
    public SortedSet<String> getValues() {
        SortedSet<String> values = new TreeSet<>();
        pointer.forEach(phone -> values.add(phone.getCost().toString()));
        return values;
    }

}
