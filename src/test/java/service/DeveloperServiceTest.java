package service;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.repository.hibernate.HibernateDevRepoImpl;
import com.service.DeveloperService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeveloperServiceTest {

    @Mock
    private HibernateDevRepoImpl hibernateDevRepo;
    private final DeveloperService developerService;

    public DeveloperServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.developerService = new DeveloperService(hibernateDevRepo);
    }

    @Test
    public void getAll() {
        Mockito.when(hibernateDevRepo.getAll()).thenReturn(Arrays.asList(
                new Developer("Ann", "Clark", Status.ACTIVE, 1L, new Specialty("Cpp"), new ArrayList<>()),
                new Developer("Zack", "And", Status.ACTIVE, 2L,  new Specialty("Java"), new ArrayList<>())));

        List<Developer> developerList = developerService.getAll();

        assertNotNull(developerList);
        assertEquals(2, developerList.size());
        assertEquals("Zack", developerList.get(1).getFirstname());
    }

    @Test
    public void getDeveloperById() {
        Mockito.when(hibernateDevRepo.getById(1L)).thenReturn(new Developer("A", "B", Status.ACTIVE, 1L, new Specialty( "Q"), new ArrayList<>()));
        Developer developer = new Developer("A", "B", Status.ACTIVE, 1L,  new Specialty( "Q"), new ArrayList<>());
        developerService.getDeveloperById(1L);

        assertNotNull(developer);
        assertEquals("A", developer.getFirstname());
        assertEquals("B", developer.getLastname());
    }

    @Test
    public void insert() {
        Mockito.when(hibernateDevRepo.insert(new Developer("A", "B",  Status.ACTIVE,1L,  new Specialty("Q"), new ArrayList<>())))
                .thenReturn(new Developer("A", "B", Status.ACTIVE, 2L, new Specialty("Q"), new ArrayList<>()));

        Developer developer = developerService.insert(new Developer( "A", "B", Status.ACTIVE, 1L, new Specialty("Q"), new ArrayList<>()));
        developer.setFirstname("909090");

        assertNotNull(developer);
        assertEquals("B", developer.getLastname());
        assertEquals("909090", developer.getFirstname());
    }

    @Test
    public void deleteById() {
        Mockito.doNothing().when(hibernateDevRepo).deleteById(1L);

        developerService.deleteById(1L);
        Mockito.verify(hibernateDevRepo).deleteById(1L);
    }

    @Test
    public void update() {
        Mockito.when(hibernateDevRepo.update(new Developer( "A", "B", Status.ACTIVE, 1L, new Specialty("Q"), new ArrayList<>())))
                .thenReturn(new Developer("A", "B", Status.ACTIVE, 2L, new Specialty("Q"), new ArrayList<>()));

        Developer developer = new Developer("A", "B", Status.ACTIVE, 1L, new Specialty("Q"), new ArrayList<>());
        developerService.update(developer);

        assertNotNull(developer);
        assertEquals("A", developer.getFirstname());
        assertEquals("B", developer.getLastname());

        developer.setId(2L);
        developer.setFirstname("Tomas");
        developerService.update(developer);

        assertNotNull(developer);
        assertEquals(2L, developer.getId().longValue());
        assertEquals("Tomas", developer.getFirstname());

    }
}