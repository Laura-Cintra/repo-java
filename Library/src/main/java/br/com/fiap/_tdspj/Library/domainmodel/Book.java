package br.com.fiap._tdspj.Library.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter
    @Setter String id;

    @Column(length = 100)
    private @Getter @Setter String title;

    @Column(length = 100)
    private @Getter @Setter String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name="PUBLISH_DATE")
    private LocalDate publishDate;

//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false)
    private @Getter @Setter Author author;

    @ManyToOne(optional = false)
    private @Getter @Setter Category category;

    @Column(length = 2000)
    private @Getter @Setter String summary;

    @Column(length = 1000)
    private String cover;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                ", category=" + category +
                ", summary='" + summary + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
