package blake2;

public class BLAKE2BHasher {
	
	
	private BLAKE2bAlgorithm hasher;
	
	public void Init() throws Exception {
		hasher = new BLAKE2bAlgorithm();
		hasher.Initialize();
	}
	
	public void Update(byte[] data, int start, int count) throws Exception {
		hasher.HashCore(data, start, count);
	}
	
	public byte[] Finish() throws Exception {
		
		byte[] fullResult = hasher.HashFinal();
		return fullResult;
		
	}
	
	public byte[] ComputeHash(byte[] data) throws Exception {
		Init();
		Update(data, 0, data.length);
		return Finish();
	}
	
	public void Reset() {
		hasher.Reset();
		hasher = null;
	}
	
	public String toString() {
		return hasher.toString();
	}
	
}
