package service;

import com.model.Specialty;
import com.repository.hibernate.HibernateSpecRepoImpl;
import com.service.SpecialtyService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SpecialtyServiceTest {

    @Mock
    private HibernateSpecRepoImpl hibernateSpecRepo;
    private final SpecialtyService specialtyService;

    public SpecialtyServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.specialtyService = new SpecialtyService(hibernateSpecRepo);
    }

    @Test
    public void getById() {
        Mockito.when(hibernateSpecRepo.getById(1L)).thenReturn(new Specialty(1L, "Java"));

        Specialty specialty = specialtyService.getSpecialtyById(1L);

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId().longValue());
    }

    @Test
    public void getAll() {
        Mockito.when(hibernateSpecRepo.getAll()).thenReturn(Arrays.asList(
                new Specialty(1L, "Java"),
                new Specialty(2L, "Cpp")
        ));

        List<Specialty> specialtyList = specialtyService.getAll();

        assertNotNull(specialtyList);
        assertEquals(2, specialtyList.size());
        assertEquals("Cpp", specialtyList.get(1).getName());
    }

    @Test
    public void deleteById() {
        Mockito.doNothing().when(hibernateSpecRepo).deleteById(1L);

        specialtyService.deleteById(1L);
        Mockito.verify(hibernateSpecRepo).deleteById(1L);
    }

    @Test
    public void update() {
        Mockito.when(hibernateSpecRepo.update(new Specialty(1L, "Q"))).thenReturn(new Specialty(1L, "Q"));

        Specialty specialty = new Specialty(1L, "X");
        specialtyService.update(specialty);

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId().longValue());
        assertEquals("X", specialty.getName());

        specialty.setId(2L);
        specialty.setName("Y");
        specialtyService.update(specialty);

        assertNotNull(specialty);
        assertEquals(2L, specialty.getId().longValue());
        assertEquals("Y", specialty.getName());
    }

    @Test
    public void insert() {
        Mockito.when(hibernateSpecRepo.insert(new Specialty(1L, "Q"))).thenReturn(new Specialty(1L, "Q"));

        Specialty specialty = new Specialty(1L, "X");
        specialtyService.insert(specialty);

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId().longValue());
        assertEquals("X", specialty.getName());
    }
}