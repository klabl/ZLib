package zservers.zlib.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

public class DimensionalList<E> implements Collection<E>, java.io.Serializable {

	private static final long serialVersionUID = -4562783473452714667L;

	private static final int maxDimensions = 255;
	private static final int maxLength = 1024;
	
	private Layer<E> value;
	
	private int dimensions;
	private int[] current;
	
	public DimensionalList(int... initialCapacities) {

		if(initialCapacities.length > maxDimensions) 
			throw new IllegalArgumentException("Dimension out of bounds: " + initialCapacities.length);
		
		dimensions = initialCapacities.length;
		value = new Layer<>(1, initialCapacities[0]);
		current = new int[initialCapacities.length - 1];
		Arrays.fill(current, 0);
		addDimension(0, value, initialCapacities);
	}
	
	private void addDimension(int index, Layer<E> current, int[] capacities) {
		
		for(int i = 0; i < capacities[index]; i++) {
			
			if(index == capacities.length - 1) {
				
				if(capacities[index] < 0 || capacities[index] > maxLength) 
					throw new IllegalArgumentException("Illegal length value: " + index);
				Layer<E> layer = new Layer<>(null, index + 1, capacities[index]);
				current.add(layer);
			} else {
				
				Layer<E> layer = new Layer<>(index + 1, capacities[index]);
				addDimension(index + 1, layer, capacities);
				current.add(layer);
			}
		}
	}
	
	public int dimensions() {
		
		return dimensions;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public int size(int... indexes) {
//		
//		
//	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public E get(int... indexes) {
		
		try {
			
			return get(value, indexes).value();
		} catch(OperationNotSupportedException ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
	
	private Layer<E> get(Layer<E> dimension, int... indexes) {
		
		if(dimension.size() == indexes.length) return dimension;
		else return get(dimension.get(indexes[dimension.getDimension()]), indexes);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public String print() {
		
		return null;
	}

	private static class Layer<T> extends ArrayList<Layer<T>> {

		private static final long serialVersionUID = -6210881419117896496L;
		
		private T value;
		private int dimension;

		public Layer(int dimension, int initialCapacity) {
			
			super(initialCapacity);
			this.dimension = dimension;
		}
		
		public Layer(T value, int dimension, int initialCapacity) {

			super(initialCapacity);
			this.value = value;
			this.dimension = dimension;
		}
		
		public int getDimension() {
			
			return dimension;
		}
		
		public T value() throws OperationNotSupportedException {
			
			if(value == null) throw new OperationNotSupportedException();
			else return value;
		}
	}
}
