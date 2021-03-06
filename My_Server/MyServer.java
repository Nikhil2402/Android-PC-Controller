
import header.local.mobilemouse.networkutil.CommandReceiver;
import header.local.mobilemouse.networkutil.CommandReceiver.DeliveryCommand;
import header.local.mobilemouse.operation.OperationData;
import header.local.mobilemouse.operation.OperationDecode;
import header.local.mobilemouse.utils.MouseUtil;

public class MyServer {
	private static final float MOVE_RATIO = 0.2f;
	public static void main(String[] args) {
		CommandReceiver receiver = new CommandReceiver(new DeliveryCommand() {
			
			@Override
			public void deliverResult(String command) {
				parseCommand(command);
				//System.out.println("received: " + OperationDecode.decode(command));
				
			}
			
			@Override
			public void deliverError(String error) {
				// TODO Auto-generated method stub
				System.out.println("Error: " + error);
			}
		});
		receiver.start();
		MouseUtil.moveCenter();
	}
	
	private static void parseCommand(String command) {
		OperationData operation = OperationDecode.decode(command);
		switch (operation.getOperationKind()) {
		case OperationData.OPERATION_MOVE:
			int moveX = (int) (operation.getMoveX() * MOVE_RATIO);
			int moveY = (int) (operation.getMoveY() * MOVE_RATIO);
			MouseUtil.moveMouse(moveX, moveY);
			break;
		case OperationData.OPERATION_CLICK_DOWN:
			MouseUtil.leftClickDown(true);
			break;
		case OperationData.OPERATION_CLICK_UP:
			MouseUtil.leftClickDown(false);
			break;
		case OperationData.OPERATION_RIGHT_CLICK:
			MouseUtil.rightClick();
			break;
		case OperationData.OPERATION_TYPE_TEXT:
			MouseUtil.typeText(operation.getInputStr());
			break;
		case OperationData.OPERATION_DEL_TEXT:
			MouseUtil.delText();
			break;
		default:
			break;
		}
	}
}

