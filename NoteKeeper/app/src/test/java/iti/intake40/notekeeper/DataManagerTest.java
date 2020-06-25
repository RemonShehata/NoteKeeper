package iti.intake40.notekeeper;

import org.junit.Assert;
import org.junit.Test;

public class DataManagerTest {

    @Test
    public void createNewNote() {
        DataManager dm = DataManager.getInstance();
        final CourseInfo course = dm.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is a text body of my test note";

        int noteIndex = dm.createNewNote();
        NoteInfo newNote = dm.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = dm.getNotes().get(noteIndex);
        Assert.assertEquals(compareNote.getCourse(), course);
        Assert.assertEquals(compareNote.getTitle(), noteTitle);
        Assert.assertEquals(compareNote.getText(), noteText);
    }
}