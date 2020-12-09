package ar.com.porloschicos.backend.contentservice.model.content;

import ar.com.porloschicos.backend.contentservice.ContentType.ContentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "contents")
public class ContentDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String images;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private Integer author;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(nullable = false)
    private Timestamp updated_at;

    public ContentDao() {
    }

    public ContentDao(String title, String content, String images, Integer type) {

        if (title.isEmpty() || content.isEmpty() || images.isEmpty()) {
            throw new IllegalArgumentException("REQUEST_INCOMPLETE");
        }

        this.setTitle(title);
        this.setContent(content);
        this.setImages(images);

        try {
            //seteo los defoult del contenido creado
            //Por default se pone un tipo de contenido: CAMPANA
            this.setType(type != null ? ContentType.getById(type).getId() : ContentType.CAMPANA.getId());
        } catch (NullPointerException exception) {
            //TODO resolve this exception
        }

        //TODO delete def author 1
        this.setAuthor(1);
        this.setStatus(true);
        this.setCreated_at(new Timestamp(System.currentTimeMillis()));
        this.setUpdated_at(new Timestamp(System.currentTimeMillis()));

    }

    public ContentDao(ContentDto contentDto) {

        this.setId(contentDto.getId());

        if (contentDto.getTitle() != null) {
            this.setTitle(contentDto.getTitle());
        }

        if (contentDto.getContent() != null) {
            this.setContent(contentDto.getContent());
        }

        if (contentDto.getImages() != null) {
            this.setImages(contentDto.getImages());
        }

        if (contentDto.getType() != null) {
            this.setType(contentDto.getType());
        }

        if (contentDto.getAuthor() != null) {
            this.setAuthor(contentDto.getAuthor());
        }

        if (contentDto.getStatus() != null) {
            this.setStatus(contentDto.getStatus());
        }

        if (contentDto.getUpdated_at() != null) {
            this.setUpdated_at(contentDto.getUpdated_at());
        }

        if (contentDto.getCreated_at() != null) {
            this.setCreated_at(contentDto.getCreated_at());
        }

    }

}
