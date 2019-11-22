package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import com.sun.xml.internal.txw2.output.StreamSerializer;

public class Day20 {
	
	Set<Particle> particles;
	
	public Day20(final FileReader fileReader) {

	        try {
	            final BufferedReader buf = new BufferedReader(fileReader);
	            int particleNumber = 0;
	            particles = new HashSet<>();

	            while(true) {
	                final String lineJustFetched = buf.readLine();
	                if(null == lineJustFetched) {
	                    break;
	                } else {
	                	final String[] pieces = lineJustFetched.split("<|>");
	                    particles.add(new Particle(particleNumber, 
	                    		Pattern.compile(",").splitAsStream(pieces[1]).mapToLong(Long::parseLong).toArray(), 
	                    		Pattern.compile(",").splitAsStream(pieces[3]).mapToLong(Long::parseLong).toArray(), 
	                    		Pattern.compile(",").splitAsStream(pieces[5]).mapToLong(Long::parseLong).toArray()));
	                    particleNumber++;
	                }
	            }
	        } catch (IOException ioe) {
	            throw new RuntimeException();
	        }
		
	}
	
	
	
	class Particle {
		
		public int getId() {
			return id;
		}

		public long[] getPosition() {
			return position;
		}

		public long[] getVelocity() {
			return velocity;
		}

		public long[] getAcceleration() {
			return acceleration;
		}

		final int id;
		long[] position;
		long[] velocity;
		long[] acceleration;
		
		public Particle(final int id, final long[] position, final long[] velocity, final long[] acceleration) {
			this.id = id;
			this.position = position;
			this.velocity = velocity;
			this.acceleration = acceleration;
		}
		
	}



	public int staysClosest() {
		// TODO Auto-generated method stub
		return -1;
	}
	
}
