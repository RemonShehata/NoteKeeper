package iti.intake40.notekeeper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataManagerTest {

    static DataManager sDataManger;

    @BeforeClass
    public static void classSetUp() {
        sDataManger = DataManager.getInstance();
    }

    @Before
    public void setUp() {
        sDataManger.getNotes().clear();
        sDataManger.initializeExampleNotes();
    }

    @Test
    public void createNewNote() {
        final CourseInfo course = sDataManger.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is a text body of my test note";

        int noteIndex = sDataManger.createNewNote();
        NoteInfo newNote = sDataManger.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = sDataManger.getNotes().get(noteIndex);
        Assert.assertEquals(course, compareNote.getCourse());
        Assert.assertEquals(noteTitle, compareNote.getTitle());
        Assert.assertEquals(noteText, compareNote.getText());
    }

    @Test
    public void findSimilarNotes() {
        final CourseInfo course = sDataManger.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText1 = "This is a text body of my test note";
        final String noteText2 = "This is a text body of second test note";

        int noteIndex1 = sDataManger.createNewNote();
        NoteInfo newNote1 = sDataManger.getNotes().get(noteIndex1);
        newNote1.setCourse(course);
        newNote1.setTitle(noteTitle);
        newNote1.setText(noteText1);

        int noteIndex2 = sDataManger.createNewNote();
        NoteInfo newNote2 = sDataManger.getNotes().get(noteIndex2);
        newNote2.setCourse(course);
        newNote2.setTitle(noteTitle);
        newNote2.setText(noteText2);

        int foundIndex1 = sDataManger.findNote(newNote1);
        Assert.assertEquals(noteIndex1, foundIndex1);

        int foundIndex2 = sDataManger.findNote(newNote2);
        Assert.assertEquals(noteIndex2, foundIndex2);
    }

    @Test
    public void createNewNoteOneStepCreation() {
        final CourseInfo course = sDataManger.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is a text body of my test note";

        int noteIndex = sDataManger.createNewNote(course, noteTitle, noteText);

        NoteInfo compareNote = sDataManger.getNotes().get(noteIndex);
        Assert.assertEquals(course, compareNote.getCourse());
        Assert.assertEquals(noteTitle, compareNote.getTitle());
        Assert.assertEquals(noteText, compareNote.getText());
    }
}