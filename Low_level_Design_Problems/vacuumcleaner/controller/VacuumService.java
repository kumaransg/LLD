/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package vacuumcleaner.controller;

import vacuumcleaner.enums.DirectionEnum;
import vacuumcleaner.model.Cell;
import vacuumcleaner.request.MoveRequest;
import vacuumcleaner.template.BizBaseCallback;
import vacuumcleaner.template.BizTemplate;
import vacuumcleaner.validator.BasicParameterValidator;
import vacuumcleaner.validator.ParameterValidator;

import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: VacuumService.java, v 0.1 2020-08-13 09:28 paras.chawla Exp $$ Request - Instruction Response - Current Cell
 */

//  T = Character(Instruction), R = Cell(Response)
public class VacuumService<T, R> extends BizBaseCallback<MoveRequest, Cell> {

    private        BizTemplate template = new BizTemplate();
    static private Cell[][]    room;
    static private Cell        currCell;
    ParameterValidator parameterValidator = new BasicParameterValidator();

    // CurrCell initialize
    private VacuumService(int x, int y, DirectionEnum dir) {
        if (x < 0 || x >= room.length || y < 0 || y >= room[0].length) {
            throw new IllegalArgumentException("can't instantiate room");
        } else {
            currCell = room[x][y] = new Cell(x, y, dir);
        }
    }

    // Vacuum service initialize
    private VacuumService(int m, int n, int x, int y, DirectionEnum dir) {
        this(x, y, dir);
        this.room = new Cell[m][n];
    }

    // "ch" -> Instruction which can be 'L','M','R'
    private Cell instruct(MoveRequest request) {
        return template.execute(request, this);
    }

    @Override
    protected void bizPreProcess(MoveRequest request, Cell result, Map<Object, Object> container) {
        try {
            parameterValidator.validate(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void bizProcess(MoveRequest request, Cell result, Map container) {
        Cell cell = request.getCurrCell();
        char instruction = request.getInstruction();
        switch (instruction){
            case 'L':
        }
    }

    @Override
    protected Cell createDefaultResult() {
        return new Cell();
    }

    public static void main(String[] args) {

        // instantiate service
        VacuumService service = new VacuumService(6, 6, 1, 2, DirectionEnum.N);

        Cell result = service.instruct(new MoveRequest(currCell, 'L'));
        /*System.out.println(service.instruct('M'));
        System.out.println(service.instruct('L'));
        System.out.println(service.instruct('M'));
        System.out.println(service.instruct('L'));
        System.out.println(service.instruct('M'));
        System.out.println(service.instruct('L'));
        System.out.println(service.instruct('M'));
        System.out.println(service.instruct('M'));*/
    }
}