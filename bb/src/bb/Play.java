package bb;

class Play implements Runnable {

	ObjectAction toss;

	Play(ObjectAction bounce) {
		toss = bounce;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			toss.update();

			try {

				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}

