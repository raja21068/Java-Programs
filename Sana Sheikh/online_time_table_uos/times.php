						<form id="times_form" action="update_times.php" method="post" >
                            <div class="row-fluid">
                                <div class="span5">
                                    <h4><i class="icon-time"></i>&nbsp;&nbsp; Morning Times</h4>
										<table>
										<?php
										require 'DatabaseManager.php';
										$times = DatabaseManager::getTimesByShift($_REQUEST['dept_id'], 1);
										$i=0;
										while($row = mysqli_fetch_array($times)){
echo'                                        <tr>
                                            <td align="right">
                                    <label>'. ($i+1) .'</label>
                                            </td>
                                            <td>
                                    <input name="time['."'".$row['time_id']."'".']" type="text" value="'.$row['time'].'" class="input-block-level" />
                                            </td>
                                        </tr>';
										$i++;
										}?>
                                    </table>                                
									</div>
                                <div class="span3">
                                    <h4><i class="icon-time"></i>&nbsp;&nbsp; Evening Times</h4>
										<table>
										<?php
										$times = DatabaseManager::getTimesByShift($_REQUEST['dept_id'], 2);
										while($row = mysqli_fetch_array($times)){
echo'                                        <tr>
                                            <td align="right">
                                    <label>'. ($i+1) .'</label>
                                            </td>
                                            <td>
                                    <input name="time['."'".$row['time_id']."'".']" type="text" value="'.$row['time'].'" class="input-block-level" />
                                            </td>
                                        </tr>';
										$i++;
										}?>
                                    </table>                                
									</div>
									</div>
                                    <br />
                                    <a onclick="$('#times_form').submit();" class=" btn  ">Save Changes&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
						</form>			
