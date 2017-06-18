package greenapp.model.sound;

import greenapp.model.photo.Image;
import greenapp.model.profile.Profile;
import greenapp.model.user.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitro on 23.05.2017.
 */
@Entity
@Table(name = "playlist")
public class Playlist {

    public Playlist() {
    }

    public Playlist(Profile profile, String description, String title, String access, String type, Image cover, Image bacground) {
        this.profile = profile;
        this.description = description;
        this.title = title;
        this.access = access;
        this.cover = cover;
        this.bacground = bacground;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(optional = false)
    @JoinColumn(name = "profile_id", unique = true, nullable = false)
    private Profile profile;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;


    @Column(name = "access")
    private String access;


    @OneToOne(optional = false)
    @JoinColumn(name = "image_id", unique = true, nullable = false)
    private Image cover;

    @OneToOne(optional = false)
    @JoinColumn(name = "background", unique = true, nullable = false)
    private Image bacground;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlists_sound", joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "sound_id"))
    private Set<Audio> sounds;


    public Audio getAudioById(long id) {
        for (Audio a : sounds) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Audio> getSounds() {
        return sounds;
    }

    public void setSounds(Set<Audio> sounds) {
        this.sounds = sounds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void add(Audio sound) {
        sounds.add(sound);
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }


    public Image getBacground() {
        return bacground;
    }

    public void setBacground(Image bacground) {
        this.bacground = bacground;
    }
}
