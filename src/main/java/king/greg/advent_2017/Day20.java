package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

	public int nonCollided() {
		for(int i = 0; i < 100; i++) {
			removeCollisions();
			for(final Particle particle: particles) {
				particle.tick();
			}
		}
		return particles.size();
	}

	private void removeCollisions() {
		Set<Particle> collidedParticles = new HashSet<>();
		for (final Particle a: particles) {
			for (final Particle b: particles) {
				if (a != b && Arrays.equals(a.getPosition(), b.getPosition())) {
					collidedParticles.add(a);
					collidedParticles.add(b);
				}
			}
		}
		particles.removeAll(collidedParticles);
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

		public long getAbsoluteAcceleration() {
			return LongStream.of(acceleration).map(Math::abs).sum();
		}

		public long getAbsoluteVelocity() {
			return LongStream.of(velocity).map(Math::abs).sum();
		}

		public void tick() {
			for (int i = 0; i < 3; i++) {
				velocity[i] += acceleration[i];
				position[i] += velocity[i];
			}
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
		return particles.stream().min(Comparator.comparing(Particle::getAbsoluteAcceleration).thenComparing(Particle::getAbsoluteVelocity)).get().getId();
	}
	
}
