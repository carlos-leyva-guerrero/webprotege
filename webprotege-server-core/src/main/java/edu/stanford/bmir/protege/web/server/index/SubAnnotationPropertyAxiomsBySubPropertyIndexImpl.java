package edu.stanford.bmir.protege.web.server.index;

import org.semanticweb.owlapi.model.*;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-15
 */
public class SubAnnotationPropertyAxiomsBySubPropertyIndexImpl implements SubAnnotationPropertyAxiomsBySubPropertyIndex {

    @Nonnull
    private final OntologyIndex ontologyIndex;

    public SubAnnotationPropertyAxiomsBySubPropertyIndexImpl(@Nonnull OntologyIndex ontologyIndex) {
        this.ontologyIndex = checkNotNull(ontologyIndex);
    }

    @Nonnull
    @Override
    public Stream<OWLSubAnnotationPropertyOfAxiom> getSubPropertyOfAxioms(@Nonnull OWLAnnotationProperty property,
                                                                          @Nonnull OWLOntologyID ontologyId) {
        checkNotNull(ontologyId);
        checkNotNull(property);
        return ontologyIndex.getOntology(ontologyId)
                .stream()
                .flatMap(ontology -> ontology.getSubAnnotationPropertyOfAxioms(property).stream());
    }
}
