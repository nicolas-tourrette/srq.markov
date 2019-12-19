package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
	
	@Test // Test a file with one word => should return a null couple
	public void testRead1WordFile() {
		Markov m = new Markov();
		m.readFile("file1Word.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		assertNull(p);
	}
	
	@Test // Test a file with two words => should return a null couple
	public void testRead2WordsFile() {
		Markov m = new Markov();
		m.readFile("file2Words.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		assertNull(p);
	}
	
	@Test // Test a file with three words => should return a not null couple
	public void testRead3WordsFile() {
		Markov m = new Markov();
		m.readFile("file3Words.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		assertNotNull(p);
	}

	@Test // Test a file with four words => should return a not null couple
	public void testRead4WordsFile() {
		Markov m = new Markov();
		m.readFile("file4Words.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 4);
		assertNotNull(res);
		System.out.println(res);
	}
}
