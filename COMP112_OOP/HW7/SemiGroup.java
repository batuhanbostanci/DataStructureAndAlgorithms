import java.util.Collection;

public abstract class SemiGroup<E> {
		
	abstract E operator(E object);
	
	
	@SuppressWarnings("unchecked")
	public static <E> E combine(Collection<E> collection) {
		 SemiGroup<E> semigroup =null;
			for(E e : collection) {
				if(semigroup ==null) {
					semigroup = (SemiGroup<E>) e;
				}
				else {
					semigroup = (SemiGroup<E>) semigroup.operator(e);
				}
			}
			return(E) semigroup;
	}
	
}
